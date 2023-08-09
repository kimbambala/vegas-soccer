<template>
    <div class="monday-card">
        <h1>Playing On Mondays</h1>
        <div v-for="group in groups" v-bind:key="group.groupId">
            <div class="main-content">
                <div class="projects">
                    <div class="group-card-grid">
                        <div class="group-card">
                            <div class="group-name">Group Name: {{ group.groupName }}</div>
                            <div class="playing-day">Day: {{ group.gameDay }}</div>
                            <div class="playing-time">Start Time: {{ group.startTime }}</div>
                            <div class="playing-type">Game type: {{ group.gameType }} </div>
                            <div class="playing-location">Location: {{ group.location}}</div>
                            <div class="playing-location-address">Adress: {{ group.address }}</div>
                            <div class="text">Additional info: {{ group.additionalInfo }}</div> 
                        </div>
                    </div>    
                </div>

            </div>
        
        </div>

    </div>
  </template>
  
  <script>
  import GroupService from "../services/GroupService";

  export default {
    name: "monday-card",
    data(){
        return {
            groups: []
        }
    },
    created(){
        GroupService.getMondayGroups().then((response)=>{
            this.groups = response.data;
            console.log(response.data);
        })
    }
  };
  </script>
  <style scoped>

.main-content{
    display: grid;
    grid-template-columns: 3.8fr 1fr;
    gap: 1.5rem;
    margin-bottom: 7rem;
    margin-left: 1.5rem;
    margin-right: 1.5rem;
    margin-top: 2rem;
  }
  
  .projects{
    text-align: left;
  }

    .group-card-grid{
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(100px, 1fr));
        color: white;
        text-align: left;
        gap: 10px 
  }

    .group-card {
        background-color: #FFFFFF;
        color: rgb(87, 87, 87);
        font-weight: normal;
        font-size: 1rem;
        padding: 1rem;
        text-align: left;
        border-radius: 0.5rem;
        border-left-style: inset;
        border-left-color: rgb(252, 194, 5);  
        border-left-width: 0.5rem;
        box-shadow: 0px 5px 5px rgb(183, 176, 176); 
        height: 300px;
    
  }
  
  .group-card .group-name {
    font-size: 1.5;
    text-align: left;
    font-weight: 600;
    color: black;
  }
  
  
  </style>