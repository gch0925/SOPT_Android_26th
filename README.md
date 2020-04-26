# SOPT_Android_26th 1차 세미나


## 1. ConstarintLayout 심화 학습

+ 새로 알게 된 내용
  + ConstraintDimensionRation 이용해서 View의  비율을 조정할 수 있다
    - width height 중 하나를 기준으로 비율 설정
    - app:layout_constraintDimensionRatio="width:height" 
  + Guideline 사용하여 가상의 선을 만들어 기준을 잡을 수 있다
    - Vertical, Horizontal 골라서 사용
    - Orientation에 따라 begin은 x만큼 start/top end는 end/bottom
    - app:layout_constraintGuide_begin="x"
    - app:layout_constraintGuide_end="x"
    - Textview에서 width를 0dp로 만들면 Guideline에 닿을시 개행된다
+ 구현 방식
    - ``` app:layout_constraintDimensionRatio="1:1" ```을 이용하여 가로 세로 크기를 1:1로 설정한다
    - Guideline의 Orientation을 Vertical로 설정하고 ``` app:layout_constraintGuide_begin="" ```을 이용하여 적절한 위치에 생성한다
    - TextView의 제약조건을 설정해주고 ``` width = "0dp" ```로 하여 guideline에 닿았을 경우 개행되도록 한다
+ 결과
<br/> <img width="200" src ="https://user-images.githubusercontent.com/46626421/80307152-54120280-8802-11ea-9f4e-91aed5184e21.png">

## 2. 회원가입 및 로그인 기능 구현하기
+ 새로 알게 된 내용
    - Kotlin에서는 onclicklistener를 사용할때 리스너 객체 만들어줄 필요가 없다
    - Edittext의 text를 가져올때 getText.toString() 대신 text.toString()을 이용한다
    - Kotlin Extension을 사용하면 findviewbyId 필요없이 view에 접근이 가능하다
    - 
+ 구현 방식
    - 회원가입 버튼에 onClickListener를 설정하고 intent와 startActivityForResult를 이용하여 회원가입 액티비티로 이동한다
      ```kotlin
      Intent(this, RegisterActivity::class.java)
      
      startActivityForResult(intent, requestCode)
      ```
    - 회원가입 후 입력한 이메일과 비밀번호는 intent와 setResult를 이용하여 로그인 액티비티로 전달한다
      ```kotlin
       val intent = Intent()
       intent.putExtra("email",et_email.text.toString())
       intent.putExtra("pw",et_pw.text.toString())
       setResult(Activity.RESULT_OK, intent)
       finish()
      ```
     - 로그인 액티비티의 onActivityResult에서 intent를 통해 데이터를 전달받는다
       ```kotlin
        if (resultCode == Activity.RESULT_OK){
            et_email.setText(data?.getStringExtra("email"))
            et_pw.setText(data?.getStringExtra("pw"))
        }
+ 결과 
<br/>  <img width="200" src="https://user-images.githubusercontent.com/46626421/80307842-94737f80-8806-11ea-91fa-02def43884ab.png">
  <img width="200" src="https://user-images.githubusercontent.com/46626421/80307845-963d4300-8806-11ea-89d3-329239802177.png">
  <img width="200" src="https://user-images.githubusercontent.com/46626421/80307844-963d4300-8806-11ea-8f03-a89d8d7dc9a8.png">
