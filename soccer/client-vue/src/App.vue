<template>
  <div id="app">
    <div id="nav">
      <!--
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }">Signin</router-link>
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      --->
    </div>
    <router-view />
  </div>
</template>
<style>

#app{
  background-color: #f1f1f1; 

}

.footer{
  grid-area: footer;
  background-color: yellow;
  text-align: center;
}

</style>