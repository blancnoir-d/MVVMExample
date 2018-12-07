package com.project.saeha.mvvmexamplejava1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.project.saeha.mvvmexamplejava1.model.User;

public class LoginViewModel extends BaseObservable {

    private User user;


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(com.project.saeha.mvvmexamplejava1.BR.toastMessage);
    }

    public LoginViewModel() {
        user = new User("", "");
}

    public void afterEmailTextChanged(CharSequence s) { // 뷰에서 입력받은 값을 모델에 set
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    // model에서 이메일 형태 확인 반환 값을 받아서.. Toast를 띄우는
    public void onLoginClicked() {
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
}