## PROOBJECT7 FIX0 (7.0.0.1.2xx) 버전의 PROOBJECT APPLICATION TEMPLATE
- PROBUILDER 혹은 PROSTUDIO를 사용하지 않고 PO7 프로젝트를 구성하고 싶을 때 사용

### 요구사항
- ProObject7 의 URL 구조 및 application/servicegroup/service 개념을 대충 알고있어야함
- ProObject7 의 디렉토리 구조 및 config 파일에 대해 어느정도 알고 있어야함
- ProObject7 런타임 바이너리가 올라간 maven repository (nexus) 가 필요함

### 사용방법
1. 이 프로젝트를 fork 한다.
2. application name 을 수정한다.
   1. `settings.gradle` 파일의 `rootProject.name` 필드
   2. `config/application.xml` 파일
3. servicegroup 을 만든다.
- 기본으로 `poservicegroup` 이라는 서비스그룹이 하나 존재하니 참고
- 추가 방법  
    1. `${ProjectHome}/settings.gradle` 파일에 servicegroup name 을 include (`include ':poservicegroup'`)
    2. `${ProjectHome}/config/application.properties` 파일에 APPLICATION_SERVICEGROUP 필드에 servicegroup name을 추가 (delimeter는 :을 사용)
    3. 프로젝트의 루트에 servicegroup name 디렉토리를 생성
    4. 다른 서비스그룹 디렉토리에 있는 `build.gradle`, `gradle.properties` 파일 복사 후 해당 파일들 설정 변경 (dependency 삭제 등)
    5. `api, config, sql, src/main/java/com/tmax/poapp/poservicegroup` 등의 필수 디렉토리 생성
    6. `config` 디렉토리에 다른 서비스그룹의 `config` 디렉토리를 참조하여 파일 생성, `servicegroup.xml` 파일에 servicegroup 의 이름 명시
4. 개발한다.  
5. 참고
- service 는 servicegroup 단위로 묶이며, `com.tmax.poapp.poservicegroup` 의 패키징을 이용. src dir 는 `$project/$servicegroup/src/main/java/com/tmax/poapp/poservicegroup`
- dataobject는 application 단위로 묶이며, `com.tmax.poapp.dataobject.poservicegroup` 의 패키징을 이용. src dir 는 `$project/src/main/java/com/tmax/poapp/dataobject` 
- event.jar 는 servicegroup 단위로 묶이며, `com.tmax.poapp.poservicegroup.event` 의 패키징을 이용. src dir 는 `$project/$servicegroup/src/main/java/com/tmax/poapp/poservicegroup/event`
### Available gradle tasks
1. buildAll
   - App을 빌드하는 task - 경로: \${APP_HOME}/build/\${APP_NAME} 디렉토리
2. tar
   - App을 빌드하고 빌드 후 tar 파일로 묶는 task
3. deploy
   - App 빌드, tar로 묶은 후에 gradle.properties 에 지정된 환경으로 deploy 및 restart script를 구동하는 task
   - gradle.properties 의 예제  
      ```properties
      org.gradle.jvmargs='-Dfile.encoding=UTF-8'
      // gradle deploy task에서만 사용
      remoteHostIp=182.168.123.123
      remoteHostUser=root
      remoteHostPwd=
      remotePOHome=/root/proobject7/ProZone/
      remoteRestartScript=/root/cmd/proiaas_restart.sh
      ```
  
4. tarAndNexusUpload
   - App 빌드, tar로 묶은 후에 각 servicegroup의 dto를 nexus에 업로드하는 task
   - 이 태스크는 jenkins에서만 구동하여야함  