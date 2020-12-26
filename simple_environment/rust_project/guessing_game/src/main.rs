extern crate rand;

use std::io;
use rand::Rng;
use std::cmp::Ordering;

fn main() {

    println!("Guss the number!");
    
    let secret_number = rand::thread_rng().gen_range(1, 101);

    println!("The secret number is: {}", secret_number);
    loop {
        println!("Please input your guess.");
        
        let mut guess = String::new();
        // mutable 변수를 생성
        // mut 을 붙이지 않으면 기본적으로 불변(immutable)
    
        io::stdin().read_line(&mut guess)
            .expect("Faild to read line");
        // 사용자의 입력을 받는 문자열 변수는 가변이어야함
        // & 는 참조자를 의미.  
        
        // read_line 
        // return io::Result 타입 값, Enum
        //          - Ok 또는 Err

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };
        // 이전의 guess 값을 Shadowing 하는 것. 

        println!("Your guessed: {}", guess);
        match guess.cmp(&secret_number){
            Ordering::Less     => println!("Too Small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal   => {
                println!("You win!");
                break;
            }
        }
        // cmp 는 Ordering enum 값을 리턴한다. 
        // match 문으로 switch case 문 같이 구현할수있음. 
    }

}

// The prelude is the list of things that Rust automatically imports into every Rust program. 
// 러스트에서 자동으로 import 하는 것들의 리스트  