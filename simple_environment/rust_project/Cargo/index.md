# Hello, Cargo!

## 카고는 무엇인가
Cargo(카고) 는 러스트의 빌드 시스템 및 패키지 매니저이다. Cargo 를 이용해서 의존성을 추가하고 의존성을 관리 할수있다. 

## 프로젝트 생성 및 실행

```bash
$ cargo new hello_cargo --bin
$ cd hello_cargo
```

- --bin 커맨드를 붙이면 실행 가능한 애플리케이션으로 만들어줌. (Binary)
- Cargo.toml, src/main.rs 를 생성해줌

**Cargo.toml**
```
[package]
name = "hello_cargo"
version = "0.1.0"
authors = ["Your Name <you@example.com>"]

[dependencies]
```
- TOML 포맷
- dependencies 라인 아래에 의존성을 추가 할수있음
- 러스트에서는 코드의 패키지를 크레이트(crate) 라고 부  

**빌드 및 실행**

```
$ cargo build
' 프로젝트를 빌드
' ./target/debug/hello_cargo 에 실행파일 저장됨.
$ cargo check
' 프로젝트 빌드
' 실행 파일 생성 단계를 생략하기때문에 빠르게 점검할수있음
$ cargo run
' 빌드 및 실행
```

```
$ cargo build --release
' 릴리즈 
```