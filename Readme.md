# jpa_schedule

### 목적 : JPA를 이용하여  일정표의 CRUD 구현

---

### API 명세서

| 기능 | 메서드 | URL             | Request | Response | 상태 코드 |
| --- | --- |-----------------| --- | --- | --- |
| 회원 생성 | POST | /users/signup   | 요청 body | 등록 정보 | 201 정상 등록  |
| 선택 회원 조회 | GET | /users          |  | 응답 정보 | 200 정상 조회  |
| 회원 정보 수정 | PATCH | /users/{id}     | 요청 body | 응답 정보  | 200 정상 등록 |
| 회원 정보 삭제 | DELETE | /users/{id}     |  |  | 204 반환 내용 없음 |
| 일정 생성 | POST | /schedules/     | 요청 body | 등록 정보 | 201 정상 등록 |
| 전체 일정 조회 | GET | /schedules      |  | 응답 정보 | 200 정상 조회 |
| 선택 일정 조회 | GET | /schedules/{id} | 요청 body | 응답 정보 | 200 정상 조회 |
| 선택 일정 수정 | PUT | /schedules/{id} | 요청 body | 등록 정보 | 201 정상 등록  |
| 선택 일정 삭제 | DELETE | schedules/{id}  |  |  | 204 반환 내용 없음 |

---

### **API 명세서 URL :**

https://documenter.getpostman.com/view/39379207/2sAY55ay6E

---

### ERD URL :

https://www.erdcloud.com/d/omcW39aZiRx4fhm5A