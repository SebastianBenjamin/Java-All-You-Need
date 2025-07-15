package org.example;

public class HelloService {

        private String message;

        public void setMessage(String message) {
            this.message = message;
        }

        public void sayHello() {
            System.out.println("Spring says: " + message);
        }


}
