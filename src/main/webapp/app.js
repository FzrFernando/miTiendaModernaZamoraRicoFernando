const username=document.querySelector("#username");
const email=document.querySelector("#email");
const password=document.querySelector("#password");
const confPassword=document.querySelector("#confPassword")
const age=document.querySelector("#age");
const conditions=document.querySelector("#conditions");
const sex=document.querySelector("input[name='sex']");


const checkUsername = () => {
    let valid = false;

    const trimUsername = username.value.trim();

    const min=3,max=20;

    if(!isRequired(trimUsername)){
        showError(username, "Cant be blank")
        // alert("NO vale, está en blanco")
    }
    else if(!isBetween(trimUsername.length, min, max)){
        showError(username, "Lenght have to be between 3 and 20")
    }
    else{
        showSuccess(username);
        valid=true;
    
    }
    return valid;
  
}

const checkEmail = () => {
    let valid = false;

    const trimEmail = email.value.trim();

    if(!isRequired(trimEmail)){
        showError(email, "Cant be blank")
    }
    else if(!isEmailValid(trimEmail)){
        showError(email, "Email is not valid")
    }
    else{
        showSuccess(email);
        valid=true;
    }
    
    return valid;
  
}

const checkSex = () => {
    let valid = false;

    const male=document.querySelector("#male");
    const female=document.querySelector("#female");

    if(male.checked==false && female.checked == false){
        showError(sex, "Cant be blank")
    }
    else if(male.checked==true && female.checked == true){
        showError(sex, "You cant choose both")
    }
    else{
        showSuccess(sex);
        valid=true;
    }
    
    return valid;
  
}


const checkAge = () =>{

    let valid = false;
    const max = 150, min = 18;
    
    const ageValue = age.value;

    if(ageValue == ""){
        showError(age,"Cant be blank")
    }

    else if(ageValue<min || ageValue>max){
        showError(age,"Age have to be more than 18 and less than 150")
    }

    else{
        showSuccess(age);
        valid=true;
    }

    return valid;
}

const checkConditions = () =>{

    let valid = false;


    if(!isCheckedCheckbox(conditions)){
        showError(conditions,"Cant be blank")
    }

    else{
        showSuccess(conditions);
        valid=true;
    }

    return valid;
}


const checkPassword = () => {
    let valid = false;


    const passwordTrim = password.value.trim();

    if (!isRequired(passwordTrim)) {
        showError(password, 'Password cannot be blank.');
    } else if (!isPasswordSecure(passwordTrim)) {
        showError(password, 'Password must has at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)');
    } else {
        showSuccess(password);
        valid = true;
    }

    return valid;
};

const checkConfirmPassword = () => {
    let valid = false;
    // check confirm password
    const confirmPassword = confPassword.value.trim();
    const passwordTrim = password.value.trim();

    if (!isRequired(confirmPassword)) {
        showError(confPassword, 'Please enter the password again');
    } else if (passwordTrim !== confirmPassword) {
        showError(confPassword, 'The password does not match');
    } else {
        showSuccess(confPassword);
        valid = true;
    }

    return valid;
};

const isPasswordSecure = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return re.test(password);
};

const isCheckedCheckbox = checkbox => checkbox.checked;
const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;



const showError = (input, message) => {
    const formField = input.parentElement;

    const warning = formField.querySelector("#warnings")

    warning.textContent = message;
}

const showSuccess = (input) => {
    const formField = input.parentElement;

    const warning = formField.querySelector("#warnings")

    warning.textContent = "";
}

form.addEventListener('submit', function (e) {
    // prevent the form from submitting
    e.preventDefault();

    // validate fields
    let isUsernameValid = checkUsername(),
        isEmailValid = checkEmail(),
        isAgeValid = checkAge();
        isPasswordValid = checkPassword(),
        isConfirmPasswordValid = checkConfirmPassword(),
        isSexChecked = checkSex(),
        isConditionsChecked = checkConditions();

    let isFormValid = isUsernameValid &&
        isEmailValid &&
        isAgeValid &&
        isPasswordValid &&
        isConfirmPasswordValid &&
        isSexChecked &&
        isConditionsChecked;

    // submit to the server if the form is valid
    if (isFormValid) {
        e.target.submit();
        console.log("HAs acabado")
    }
});

// form.addEventListener("input", function(e){
//     checkUsername();
//     checkEmail();
//     checkSex();
//     checkAge();
//     checkConditions();
//     checkPassword();
//     checkConfirmPassword();
// })


form.addEventListener('input', function (e) {
    switch (e.target.id) {
        case 'username':
            checkUsername();
            break;
        case 'email':
            checkEmail();
            break;
        case 'age':
            checkAge();
            break;
        case 'password':
            checkPassword();
            break;
        case 'confirm-password':
            checkConfirmPassword();
            break;
        case 'sex':
            checkSex();
            break;
        case 'conditions':
            checkConditions();
            break;
    }
});


// const debounce = (fn, delay = 500) => {
//     let timeoutId;
//     return (...args) => {
//         // cancel the previous timer
//         if (timeoutId) {
//             clearTimeout(timeoutId);
//         }
//         // setup a new timer
//         timeoutId = setTimeout(() => {
//             fn.apply(null, args)
//         }, delay);
//     };
// };

// form.addEventListener('input', debounce(function (e) {
//     switch (e.target.id) {
//         case 'username':
//             checkUsername();
//             break;
//         case 'email':
//             checkEmail();
//             break;
//         case 'password':
//             checkPassword();
//             break;
//         case 'confirm-password':
//             checkConfirmPassword();
//             break;
//     }
// }));

