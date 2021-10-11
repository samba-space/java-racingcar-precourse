# 자동차 경주 게임
## 기능 목록
- 전진 이동 기능
  - energy 4이상 전진, 3이하 멈춤
  - 이동 시, "기존 + 더할거리" 가 int max 보다 큰 경우 에러 처리
  - 이동거리는 0을 포함한 양의 정수
    - 음수일 경우 에러 처리
  - 자동차이름은 5자 이하
    - 공백, 빈문자열일 경우 에러 처리
    - 5글자 초과할 경우 에러 처리
- 참가 자동차 목록 validation 기능
  - 자동차 이름이 중복된 경우 에러 처리
  - 자동차 목록이 null 또는 empty인 경우 에러 처리
- 입력에 따른 자동차 목록 이동 기능
  - 랜덤 수가 null 또는 empty인 경우 에러 처리 
  - 랜덤 수 목록과 자동차 목록의 수가 일치하지 않으면 에러처리
- 현재 자동차들의 이동거리 조회 기능
- 우승자 선출 기능
  - 중복 가능
- 입력 기능
  1. 참가 자동차 이름 입력 기능
     - ,로 구분
     - 시작 끝 공백문자 처리
  2. 이동 회수 입력 기능
     - 숫자의 입력 범위(0 불가)
     - 숫자가 아닐 경우
- 결과 출력기능
  1. 현재 결과
  2. 우승자 출력

## 초기 설계 다이어그램
![초기다이어그램](./img/클래스다이어그램(초기).png)