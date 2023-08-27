<template>
  <div id="login">
    
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="mb-3">
        <label for="username"></label>
        <input autocomplete="off" autofocus class="form-control mx-auto w-auto" id="username" name="username" placeholder="Username" type="text" v-model="user.username" required/>
      </div>
      <div class="mb-3">
        <label for="password"></label>
        <input class="form-control mx-auto w-auto" id="password" name="password" placeholder="Password" type="password" v-model="user.password" required />
      </div>
      <button class="btn btn-primary" type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>

  </div>
</template>

<script>
import authService from "../services/AuthService";


export default {
  name: "login",

  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#login{
  text-align: center;
  display: flex;
  justify-content: center;
  align-content: center;
  height: 100vh;



}
.mb-3 {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

</style>