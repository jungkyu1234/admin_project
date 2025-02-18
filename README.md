# Spring MVC Project

## 프로젝트 개요
이 애플리케이션은 **Spring MVC**를 기반으로 개발되었으며, 다양한 기술 스택을 활용하여 도메인 기반의 개발을 완성했습니다. 본 프로젝트는 전 과정에서 모든 코드를 직접 작성하여 구현했습니다.

## 기술 스택
- **Spring MVC**: 웹 애플리케이션의 핵심 프레임워크
- **MyBatis**: SQL 매퍼 프레임워크로 데이터베이스 연동
- **JPA (Java Persistence API)**: 객체-관계 매핑을 통한 데이터베이스 처리
- **Thymeleaf**: 서버 사이드 템플릿 엔진으로 뷰 구현

## 주요 기능
- 도메인 기반 설계(Domain-Driven Design)를 통한 명확한 비즈니스 로직 분리
- Spring MVC 컨트롤러와 서비스 계층을 활용한 효율적인 요청 처리
- MyBatis와 JPA를 병행하여 유연한 데이터 접근 제공
- Thymeleaf를 사용한 사용자 친화적인 웹 페이지

## 프로젝트 구조
```
/src
│
├── /main
│   ├── /java
│   │   └── com.example.project
│   │       ├── /config
│   │       ├── /controller
│   │       ├── /domain
│   │       ├── /repository
│   │       ├── /service
│   │       └── /SpringMvcProjectApplication.java
│   └── /resources
│       ├── /static
│       ├── /templates
│       └── application.yml
└── /test
```

## 데이터베이스
- 데이터베이스는 MySQL을 사용하며, MyBatis와 JPA를 통해 데이터 처리를 수행합니다.
- 도메인 객체와 매퍼 인터페이스를 활용하여 SQL 쿼리를 관리합니다.

## 실행 방법
1. 프로젝트 클론

```bash
git clone https://github.com/your-repo/spring-mvc-project.git
cd spring-mvc-project
```

2. 의존성 설치 및 빌드

```bash
./mvn clean install
```

3. 애플리케이션 실행

```bash
java -jar build/libs/spring-mvc-project.jar
```

## 기여
- 본 프로젝트는 개인 프로젝트로, 모든 코드는 직접 작성하였습니다.

## 라이선스
MIT 라이선스를 준수합니다.

---

이 프로젝트에 대한 문의 사항은 언제든지 연락 주시기 바랍니다! 🚀

