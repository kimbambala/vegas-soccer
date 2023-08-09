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

                <router-link v-bind:to="{ name: 'tuesday' }"><p>Wednesday</p></router-link>

            </li>
            <li>
                <a class="thursday-groups" href="thursday.html"><p>Thursday</p></a>
            </li>
            <li>
                <a class="friday-groups" href="friday.html"><p>Friday</p></a>
            </li>
            <li>
                <a class="saturday-groups" href="saturday.html"><p>Saturday</p></a>
            </li>
            <li>
                <a class="sunday-groups" href="sunday.html"><p>Sunday</p></a>
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