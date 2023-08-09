<template>
    <div class="main-card">
      <h1>Playing Today</h1>
      <div v-for="group in groups" v-bind:key="group.groupId">
        {{ group.groupName }}

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