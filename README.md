# SOPT_Android_26th 2차 세미나


## 1. Bottom Navigation, ViewPager, RecyclerView 이용해서 직접 실습 해보기


+ 실습한 결과물
  <br/> <img width="200" src ="https://user-images.githubusercontent.com/46626421/81382349-35d4cc80-9149-11ea-8fe0-cc15abaa5a08.gif">
+ 새로 알게 된 내용  
  + Selector
    View의 속성
    ```
    app:itemIconTint="@color/bottom_selector"
    app:itemTextColor="@color/bottom_selector"
    ```
    Selector 정의
    ```
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:color="#d9d9d9"
        android:state_checked="false"/>
    <item 
        android:color="#000000"
        android:state_checked="true" />
    </selector>
    ```
    위와같이 Selector를 적용하여 View의 state에 따라 색상등을 다르게 설정해 줄 수 있다.
    
    
  
## 2. RecyclerView의 itemDecoration, clipToPadding에 대해 공부해보고 적용해보기
### itemDecoration
 - ```
   class MyItemDecoration(val index : Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = index
    }
   ```
  - ```
    main_recyclerview.addItemDecoration(MyItemDecoration(x))
    ```
  - 위와 같이 RecyclerView.ItemDecoration을 상속받고 getItemOffsets의 outRect의 top,bottom,left,right 속성을 이용하여 아이템에
  여백을 x만큼 줄 수 있다 아래 예시는 상단 여백만을 조정한 예시이다
  - <br/> <img width="200" src ="https://user-images.githubusercontent.com/46626421/81382754-d7f4b480-9149-11ea-8806-9c6b9718b771.png">


### clipToPadding
  - ClipToPadding은 리사이클러뷰를 padding된 영역 안에서만 붙여주는 속성이다.
   ```ClipToPadding="false" ```로 만들어주면 스크롤시에는 padding없이 원래 뷰의 영역에서 움직이게 된다
   <br/>아래 예시는 true/false를 비교한 예시이다. false를 적용한 오른쪽을 보면 처음 padding과는 상관없이 스크롤 되는 모습을 볼 수 있다.
   <br/> <img width="200" src ="https://user-images.githubusercontent.com/46626421/81382724-cca18900-9149-11ea-9a9f-49a3cf5417ff.gif">  <img width="200" src ="https://user-images.githubusercontent.com/46626421/81382836-fd81be00-9149-11ea-8308-52c77cc7be5c.gif">
    
