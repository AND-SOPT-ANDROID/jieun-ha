package org.sopt.and.presentation.util

/* SideEffect를 의미
* Composable 함수가 재구성될 때 상태 변화를 감지하고 부수적인 작업을 실행
* ui와 직접적으로 관련되지 않은 외부 작업 수행(DB 업데이트, 네트워크 요청)*/
interface UiEffect