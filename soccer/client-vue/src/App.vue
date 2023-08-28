<template>
  <div id="app">
    <div id="nav">
      <nav-bar />
      <!--
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }">Signin</router-link>
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      --->
    </div>

    <div class="content">
      <router-view />

    </div>

    <footer class="footer">
      <footer >&#169; Nick Ngouma</footer>
    </footer>
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue';

export default {
  name: "home",
  components:{
    NavBar
  }
};
</script>
<style>

#nav{
  grid-area: nav;


}

.content{
  grid-area: content;
  margin-top: 10px;
}

.footer{
  background-color: #CC9933;
  color: white;
  margin-top: 100px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  bottom:0;
  width: 100vw;
  grid-area: footer;
}

#app{
  background-color: #f1f1f1; 
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: 
  'nav'
  'content'
  'footer';

}



</style>