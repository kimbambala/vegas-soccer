<template>
<div class="side-bar">
        <div class="dashboard">See groups per day:</div>
        <ul class="list">
            <li>
                
                <router-link v-bind:to="{ name: 'monday' }"><p>Monday</p></router-link>
              
            </li>
            <li>
        
                <router-link v-bind:to="{ name: 'tuesday' }"><p>Tuesday</p></router-link>


            </li>
            <li>

                <router-link v-bind:to="{ name: 'wednesday' }"><p>Wednesday</p></router-link>

            </li>
            <li>
                
                <router-link v-bind:to="{ name: 'thursday' }"><p>Thursday</p></router-link>


            </li>
            <li>

                <router-link v-bind:to="{ name: 'friday' }"><p>Friday</p></router-link>

            </li>
            <li>

                <router-link v-bind:to="{ name: 'saturday' }"><p>Saturday</p></router-link>

            </li>
            <li>
                <router-link v-bind:to="{ name: 'sunday' }"><p>Sunday</p></router-link>

            </li>
        </ul>
    </div>
  </template>
  
  <script>

  export default {
    name: "side-bar",
    data(){
        return {
            groups: []
        }
    },

  };
  </script>
  <style scoped>
  .side-bar{
    background-color: rgb(39, 9, 213);
    color: #FFFFFF;
    font-size: larger;
    text-align: center;
    
  }

  .list{
    display: grid;
    font-weight: 600;
    margin-top: 20px;
    text-align: center;
   
  }
  
  li {
    display: flex;
    flex-direction: row;
    list-style: none;
    text-align: center;
    
  }


  </style>