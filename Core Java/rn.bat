@echo off
powershell -NoProfile -ExecutionPolicy Bypass -Command " 
$files = Get-ChildItem -Filter '*.java' 
foreach ($file in $files) {
    if ($file.Name -match ' \([0-9]+\)\.java$') {
        $newName = $file.Name -replace ' \([0-9]+\)', ''
        $originalPath = Join-Path $file.DirectoryName $newName

        if (-not (Test-Path $originalPath)) {
            Rename-Item $file.FullName -NewName $newName
            Write-Host ('Renamed: {0} → {1}' -f $file.Name, $newName)
        }
        else {
            $hash1 = Get-FileHash $file.FullName
            $hash2 = Get-FileHash $originalPath

            if ($hash1.Hash -eq $hash2.Hash) {
                Write-Host ('Deleting duplicate: {0}' -f $file.Name)
                Remove-Item $file.FullName -Force
            }
            else {
                Write-Host ('Conflict found: {0} ≠ {1}' -f $file.Name, $newName)
            }
        }
    }
}
"
pause
