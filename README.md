# How to Study 🤼
### Issue
- 풀고자하는 문제 **Issue** 올리기   
- **Issue**에 있는 문제 풀기 
### Pull Request
- 본인의 문제 풀이 **Commit**을 **Pull Request** 올리기
### Code Review
- 모임 날 각자의 PR에 담긴 코드와 코멘트 보면서 **Code Review**
- **Reviewer & Reviewee**    
    반드시 한 명 이상의 PR을 Review!  
    > 24.07.23  
    >  [장한](https://gitub.com/newbieJanghan) -> [진호](https://github.com/SON1205) -> [혁규](https://github.com/Huk9uri) -> [소현](https://github.com/elsa-kim)
    >   
 
# How to Commit 💻
### Commit Message
> [#이슈_넘버] 문제_유형 / 성공_여부: 풀이_요약  
> 
> ex. [#1] 스택 /  Fail: Array 활용, 시간 초과  

1. **[#이슈_넘버]**  

    해당 항목은 Github UI 상에서 커밋 로그 상에 이슈로의 하이퍼링크 기능을 합니다.    
    풀고자 하는 문항 별 이슈가 등록되어 있습니다. 이슈 번호를 확인하여 커밋을 작성합니다.  

2. **문제_유형**  

    알고리즘 문항은 여러 유형으로 분류될 수 있습니다.    
    우리 또는 본인이 연습하고자 했던 유형/주제 를 작성해주세요.   
 
3. **성공_여부**  
    Pass OR Fail 로 기재합니다.
    > 💡 왜 Fail도 올리나요?   
    >
    > - 자신은 내가 실패한 방식에 대한 피드백을 받을 수 있습니다. 🌱   
    > - 스터디원은 오류를 발견하고, 다른 풀이법이 안 되는 이유를 탐색하는 과정을 통해 성장합니다. 💯   

4. **풀이_요약**  
    한 줄로 본인이 활용한 풀이법과 성공/실패 이유를 기재합니다.

### Branching Strategy
1. **main** branch로 이동한 후 새로운 **branch**를 생성합니다.
    ```bash
    git checkout main
    git checkout -b "새 branch"
    ```
2. 진행한 브랜치를 remote repository (origin) 으로 **push**합니다.
    ```bash
    git push origin "새 branch" // main X
    ```
