Note
=============
##### by Song

### Study Day
- 2020.01.27

#### Important things
***2021.01.***
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
  - ~p.62 