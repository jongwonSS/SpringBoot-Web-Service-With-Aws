Note
=============
##### by Song

### Study Day
- 2020.01.27
- 2020.02.03
- 2020.04.21
- 2020.04.22

#### Important things
***2021.01.27***
  - TDD : 테스터가 주도하는 개발
    - 테스트 코드 먼저 작성
    - https://repo.yona.io/doortts/blog/issue/1
  - 단위 테스트 : TDD의 첫번째 단계

  - SpringApplication.run : 내장 WAS(Web Application Server) 실행
  - 외장 WAS 사용 시, 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야 한다.

  - @SpringBootApplication이 있는 위치부터 설정을 읽어가므로 해당 클래스는 프로젝트 최상단에 위치
  - @RestController
    - Controller를 JSON을 반환하는 Controller를 만들어 줌.
    - @ResponseBody를 각 메소드마다 선언해서 사용했던 것을 한번에 사용가능하도록
  - @GetMapping
    - HTTP Method Get 요청 처리 API

  - Gradle 버전 변경으로 인한 오류 수정 (현재까지는 완)

***2021.02.03***
  - @Autowired
    - 생성자나 세터 등을 사용하여 의존성 주입을 하려고 할 때, Spring이 관리하는 해당 빈을 찾아서 주입
  - @RequestParam
    - 외부에서 API로 넘긴 Params를 가져오는 Anotation

  - Lombok : 자바 개발자들의 필수 라이브러리
    - Getter, Setter, 기본생성자, toString 등을 어노테이션으로 자동 생성

  - assertji : 테스트 검증 라이브러리
    - 장점 : 'assertji가 JUnit의 assertThat보다 편리한 이유 영상' 볼 것(백기선 유투브)
      - JUnit의 assertThat 사용 시, CoreMatchers 라이브러리 필요
        assertji의 경우. 필요없음.
      - 자동완성이 좀 더 확실하게 지원됨.
    - assertThat() : assertji 테스트 검증 라이브러리의 검증 메소드 + 메소드 체이닝 지원
    - isEqualTo() : 동등 비교 메소드

  - param()
    - API 테스트시, 요청 파라미터 설정 (String 값만 가능)
  - jsonPath()
    - JSON응답값을 필드별로 검증
    - $기준 필드명 명시

***2021.04.21***
  - MyBatis : SQL Mapper, (ORM이 아님)
  - JPA : 인터페이스 (자바 표준 명세)
    - 객체지향 프로그래밍 언어와 관계형 데이터 베이스의 중간 역할
    - SQL에 종속적이지 않은 개발 가능
  - Spring Data JPA : 모듈
    - JPA <- Hibernate <- Spring Data JPA
      - 사실 Hibernate와 Spring Data JPA를 쓰는 것은 큰 차이가 없으나, Spring Data JPA의 2가지 이유가 있음.
        - 구현체 교체의 용이 ; Hibernate 외의 다른 구현체로 교체 가능
        - 저장소 교체의 용이 : 관계형 데이터베이스 외의 다른 저장소로 교체 가능
    * Spring Data 하위 프로젝트들은 기본적으로 CRUD의 인터페이스가 동일 (ex) Spring Data Redis, etc)

  - domain : 소프트웨어에 대한 문제(요구사항) 영역
  - Entity 클래스는 절대 Setter 메소드를 만들지 않음.
    - 기본적으로 생성자를 통해 최종값을 DB에 insert
      값 변경의 경우, 해당 이벤트에 맞는 public 메소드를 호출하여 변경
  - JPA annotation
    - @Entity : 테이블과 링크될 클래스 (SaleManager.java CLASS -> sales_manager TABLE)
    - @Id : 테이블 PK
    - @GeneratedValue : PK 생성 규칙
    - @Column : 테이블 컬럼 (기본적으로 선언하지 않아도, 해당 클래스 필드는 모두 컬럼이나 size나 type 변환시 사용)
  - Repository (인터페이스) : DB Layer 접근자
    - Entity 클래스와 기본 Entity Repository는 같이 위치해야 함. 
      -> 전에 할 때는 import를 통해 다른 디렉토리로 관리했는데, 뭐가 맞는건지 찾아보자(domina 패키지 안만 같으면 된다는 건가?)

  - Junit
    - @AfterEach : 단위 테스트가 끝날 때마다 수행되는 메소드 지정
  
  - Spring 웹 계층
    - Web Layer : 외부 요청과 응답에 대한 전반적인 영역 = 뷰 템플릿 영역
      - 컨트롤러, JSP/Freemarker, 필터, 인터셉터, 컨트롤러 어드바이스 등
    - Service Layer : 트랜잭션, 도메인 간 순서 보장 역할
      - 컨트롤러와 Dao 중간 영역
      - @Transaction 사용
    - Repository Layer : Database와 같이 데이터 저장소에 접근하는 영역 = Dao
    - Dtos : 계층 간에 데이터 교환을 위한 객체
    - Domain Model

  - 트랜잭션 스크립트 : 기존 서비스 처리 방식
    - 서비스 클래스 내부에서 모든 로직 처리
    - 서비스 계층이 무의미하고, 객체란 단순한 데이터 덩어리

  *tip) 기본적으로 Entity의 PK는 Long타입의 AUto_increment 추천*
    why) 비즈니스 상 유니크키(주민번호), 복합키가 PK일 경우 난감한 상황이 발생
      1) FK 맺을 때, 타 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야 하는 상황 발생
      2) 인덱스에 좋지 않음
      3) 유니크한 조건이 변경될 경우, PK 전체 수정 필요
  *tip) 생성자와 Builder의 차이*
    생성 시점에 값을 채워주는 역할은 같으나, 생성자의 경우 지금 채워야할 필드가 무엇인지 명확히 지정할 수 없음.

***2021.04.22***
  - 스프링 Bean 주입 방법
    1) @Autowired
    2) setter
    3) 생성자 : 스프링 권장 - 생성자로 Bean 객체를 받게 하면, @Autowired와 동일한 효과
  - @RequiredArgsConstructor : final이 선언된 모든 필드를 인자값으로 생성자를 대신 생성
  - Entitiy 클래스와 거의 유사한 형태여도 Dto 클래스를 추가로 생성하는 이유
    : Entity 클래스는 DB와 맞닿은 핵심 클래스이기에, 변경이 자주 있을 경우 Cost가 너무 큼
    -> View Layer와 DB Layer는 역할 분리를 철저하게 할 것
  - @WebMvcTest
    - JPA 기능 작동 X
    - Controller와 ControllerAdvice 등 외부 연동과 관련된 부분만 활성화
  - @SpringBootTest, TestRestTemplate : JPA 기능 작동
  - JPA의 영속성 컨텍스트 : 엔티티를 영구 저장하는 환경
    - JPA의 핵심 내용
    - JPA의 엔티티 매니저가 활성화된 상태(= Spring Data JPA의 경우, 기본 Option)일 시, 트랜잭션 안에서 DB 데이터를 가져오면, 영속성 컨텍스트 유지
      즉, 트랜잭션이 끝나는 시점에 해당 테이블에 변경분이 반영되어, 쿼리를 날릴 필요없이 Entity의 데이터 변경만 하면 됨
    - Dirty Checking : https://jojoldu.tistory.com/415 찾아보자
