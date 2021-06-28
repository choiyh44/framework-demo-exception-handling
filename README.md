# framework-demo-exception-handling
- [Spring 참조 문서](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-web-applications.spring-mvc.error-handling)
- 스프링 부트에서는 오류발생 시 처리를 위해 /error 맵핑이 제공된다.
  - machine client에는 오류status와 메세지를 포함한 JSON 응답이 제공되고
  - browser client에는 html 형태의 "white lebel" error view가 제공된다.
- server.error properties 설정으로 오류 동작을 customizing할 수 있다.
- BasicErrorController상속하여 ErrorController 를 새로 작성할 수도 있다.
- @ControllerAdvice 클래스를 작성하여 오류처리를 할 수도있다.(일반적으로 가장 많이 쓰이는 방식이 아닐까?)
- Custom Error Page
  - /error 폴더 아래에 404.html 50x.html 등을 넣어두면 해당 오류상태 시 해당 페이지가 표시된다.
  - 아니면 ErrorViewResolver를 상속한 클래스를 만들어서 오류상태에 따른 오류뷰를 제공할 수 있다.

