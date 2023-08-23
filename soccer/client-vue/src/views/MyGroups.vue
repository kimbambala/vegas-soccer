<template>
    <div class="home">
      <header class= "nav-bar">
        <nav-bar />
      </header>

      <h1>My groups page</h1>
      <my-groups-card />
  
  
      <footer class="footer">
        <h4>&#169; Nick Ngouma</h4>
      </footer>
      
    </div>
  </template>
  
  <script>
import MyGroupsCard from '../components/MyGroupsCard.vue';

  export default {
    name: "mygroups",
    components:{
      MyGroupsCard
    }
  };
  </script>
  <style scoped>
  
  
  </style>