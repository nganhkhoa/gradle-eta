module Hello (sayHello) where

foreign export java "@static com.example.Hello.myInt" myInt :: Int
myInt = 4

foreign export java "@static com.example.Hello.sayHello" sayHello :: String
sayHello = "Hello from Eta from Android"
