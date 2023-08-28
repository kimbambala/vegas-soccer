<template>
    <div class="main-card">
      <h1>Playing Today</h1>
      <div class="main-content">
          <div v-for="group in groups" v-bind:key="group.groupId">
              <div class="projects">
                  <div class="group-card-grid">
                      <div class="group-card">
                        <div class="info-data">
                          <div class="group-name">Group Name: {{ group.groupName }}</div>
                          <div class="playing-day"> <span class="data-name">Day:</span> {{ group.gameDay }}</div>
                          <div class="playing-time"> <span class="data-name">Start Time: </span> {{ group.startTime }}</div>
                          <div class="playing-type"> <span class="data-name">Game type: </span>{{ group.gameType }} </div>
                          <div class="playing-location"> <span class="data-name">Location: </span>{{ group.location}}</div>
                          <div class="playing-location-address"> <span class="data-name">Adress: </span>{{ group.address }}</div>
                          <div class="text"><span class="data-name">Additional info: </span>{{ group.additionalInfo }}</div> 
                        </div>
                        <div class="card-image">
                          <img src="../assets/images/jonathan-petersson-ARU18GpF6QQ-unsplash.jpg" alt="">
                        </div>

                      </div>
                  </div>    
              </div>
              
          </div>
      </div>
    </div>
  </template>
  
  <script>
  import HomeService from "../services/HomeService.js";

  export default {
    name: "main-card",
    data(){
        return {
            groups: []
        }
    },
    created(){
        HomeService.listAllGroups().then((response)=>{
            this.groups = response.data;
            console.log(response.data);

        })
    }
  };
  </script>
  <style scoped>
    .main-content{
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(400px, 1fr));
        gap: 10px;
        margin-bottom: 7rem;
        margin-left: 1.5rem;
        margin-right: 1.5rem;
        margin-top: 2rem;
      }
      
      .projects{
        text-align: left;
      }

      .group-card-grid{
        color: white;
        text-align: left;
        gap: 2px 
      }

      .group-card {
        background-color: #FFFFFF;
        color: rgb(87, 87, 87);
        font-weight: normal;
        font-size: 0.7rem;
        text-align: left;
        border-radius: 0.5rem;
        border-left-style: inset;
        border-left-color: rgb(252, 194, 5);  
        border-left-width: 0.5rem;
        box-shadow: 0px 5px 5px rgb(183, 176, 176); 
        display: flex;
        height: 280px;
        flex-direction: row; 

      }
      
      .group-card .group-name {
        font-size: 1.5;
        text-align: left;
        font-weight: 600;
        color: black;
      }

      .card-image{
        width: 550px;

      }
      .info-data{
        width: 100%;
        padding: 1rem;
      }

      img{
        width: 100%;
        height: 100%;
        
      }

      .data-name{
        color: black;
        font-weight: bold;
      }
  




  </style>