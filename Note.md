Note
=============
##### by Song

### Study Day
- 2020.01.27
- 2020.02.03

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