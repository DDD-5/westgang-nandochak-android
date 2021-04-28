# westgang-nandochak-android


# Environment Setting

kotlin version 1.3.72-release-Stuio4.1-5

Android Stuio Version 4.1

# Convention

**kotlin - kotlin Convention**

**xml - id 표기법 camel (중복 불가)**

- layout 은 최대한 constraintLayout 으로 할 것

**value** 

- 공용 속성에 대해서 : common_기능_목적
- string.xml : 사용처_기능_목적 : 예시) ex_dialog_title
- style.xml : 효진님과 논의 후 결정
- dimen.xml : 뷰이름_목적 및 기능_속성값_상세 속성값 : 예시) map_title_margin_top
- drawble
    - ui_background_색상_속성값 : 예시)ui_background_yellow_round_5
    - icon의 경우 : icon_이름_색상_속성 : 예시) icon_start_yellow, icon_start_empty


# Package

data

  model, dto, dao, repository

util - 최소 2가지 이상의 곳에서 사용되는 것들

  NandochackApplication, ToastHelper, ImageLoder, StorageHelper, AppConfig, NetworkHelper

module

  NetworkStatueChecker, NetworkConfig

firebase

  firebase 관련 작업물들

view

  main

    MainViewmodel, MainActivity, MainConfig

  splash
    SplashViewmodel, SplashActivity...


# Architecture Pattern

**MVVM - Model, View, ViewModel (Base line 코드 작성해서 따라서 적용)**

**View → Viewmodel →(bussiness logic) → model → network , db 관련 작업 (accessor)**

DI - 적용 (Hilt)

Clean Architecture  - 적용 x

Test code - 적용 x

# Build 환경 분리

- testbed
- stage
- release

# Git Branch 정책

- main → 릴리즈가 되었을 때 머지
- develop → 기능개발의 모체 브랜치 (빌드가 무조건 되어야함)
- release → stage
- feature → 기능개발 (이슈 위주, github 이슈번호, 예시) #1, #2)
- (hotfix → master 에서 나오는 기능)

## Commit message

---

#이슈번호 - 기능 축약

-구현내용

-구현내용

---

## Pull request

develop ← feature

release ← release/관련버그들

최대한 상세하게

리뷰는 더 상세하게

원격 브랜치는 merge 한사람이 삭제

**library 사용시 최소 star 1k 이상**
