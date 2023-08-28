<template>
    <div class="nav-bar">
        <nav class="navbar ">
            <div class="container-fluid">
              
              <router-link class="navbar-brand" v-bind:to="{ name: 'home' }">Las Vegas Pickup Soccer Board</router-link>
              <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                  <h5 class="offcanvas-group-name" id="offcanvasNavbarLabel">Register / Edit group </h5>
                  <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                  <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li class="nav-item">
                      
                      <router-link class="nav-link active" aria-current="page" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
                    </li>
                    <li class="nav-item">                   

                      <router-link class="nav-link active" aria-current="page" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
                    </li>

                    <li class="nav-item">                   
                      <router-link class="nav-link active" aria-current="page" v-bind:to="{ name: 'profile', params:{userId: this.$store.state.user.id}}" v-if="$store.state.token != ''">My profile</router-link>
                    </li>

                    <li class="nav-item">                   
                      <router-link class="nav-link active" aria-current="page" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
                    </li>

                  </ul>
                </div> 
              </div>
            </div>
        </nav>
    </div>
  </template>
  
  <script>

  export default {
    name: "nav-bar",
    data(){
        return {
            groups: []
        }
    },

  };
  </script>
  <style>
  
    .navbar-brand{
    font-size: 1.7rem;
    margin-left: 10px;
    color: white;
    }
    .nav-bar{
      background-color: #CC9933
    }

    .navbar-toggler{
      margin-right: 10px;
    }

    .navbar-toggler:hover{
      color: black;
      font-weight: bolder;
    }

    .offcanvas{
      background-color: #CC9933;
    }

    .offcanvas-body{
      font-size: 25px;
      text-align: center;
    }

    .nav-link:hover{
      background-color: white;

    }


  </style>