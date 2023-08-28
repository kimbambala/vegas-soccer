<template>
  <div id="register" class="text-center">

    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="mb-3">
        <label for="username"></label>
        <input autocomplete="off" autofocus class="form-control mx-auto w-auto" id="username" name="username" placeholder="Username" type="text" v-model="user.username" required />
      </div>
      <div class="mb-3">
        <label for="password"></label>
        <input class="form-control mx-auto w-auto" id="password" name="password" placeholder="Password" type="password" v-model="user.password" required />
      </div>
      <div class="mb-3">
        <label for="confirmPassword"></label>
        <input class="form-control mx-auto w-auto" type="password" id="confirmPassword" placeholder="Confirm Password" v-model="user.confirmPassword" required />
      </div>
      <button class="btn btn-primary" type="submit">Create Account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? <span class="login">Log in.</span></router-link></p>
    </form>


  </div>
</template>

<script>
import authService from '../services/AuthService';


export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#register{
  display: flex;
  justify-content: center;
  height: 100vh;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

a:link, a:visited {
    color: black;
    text-decoration: none;
}

.login:hover{
  color: #CC9933;
}

.login{
  color: #CC9933;
  font-weight: bold;
}
</style>
