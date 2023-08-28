<template>
    <div class="home">

      <div class="image-greeting">

        <div class="image">
          <img src="../assets/images/profilepic.jpg" alt="">
        </div>

        <div class="greeting">Hello {{ $store.state.user.username }}!</div>
      </div>

      <br>

      <h1>My groups</h1>
 
      <div class="add-group">
        <button class="add-button">
          <div class="add-text">
            <router-link v-bind:to="{ name: 'create', params:{userId: $store.state.user.id}}"><p>Add a new group</p></router-link>
          </div>
        </button>
      </div>
      <br>
      <div class="group-card">
        <my-groups-card/>

      </div>

      <footer class="card-footer">

      </footer>
    
      
    </div>
  </template>
  
  <script>
import MyGroupsCard from '../components/MyGroupsCard.vue';

  export default {
    name: "profile",
    components:{
     MyGroupsCard
    }
  };
  </script>
  <style>

.greeting{
    margin-top: 10px;
    font-size: 25px;
    margin-left: 10px;
    text-transform: capitalize;
  }

  .home{
    margin-left: 20px;
    margin-right: 20px;
  }

  a{
    text-decoration: none;
  }

  .add-text{
    margin-top: 15px;
    font-size: 15px;
  }

  .add-button{
    background-color: green;
  }

  a:link, a:visited{
    color: white;
    text-decoration: none
  }

  .card-footer{
    height: 50px;
}

img{
  height: 40px;
  width: 40px;
}

.image-greeting{

  display: flex;
  flex-direction: row;
  background-color: white;
}
  

  
  
  </style>