<template>
    <div class="main-card">  
      <table class="table">
        <thead class="thead">
          <tr class="td">
            <th>Group Name</th>
            <th>Day</th>
            <th>Start <Time></Time></th>
            <th>Game Type</th>
            <th>Location</th>
            <th>Address</th>
            <th>Additional Info</th>
            <th>Edit Group</th>
            <th>Delete Group</th>
          </tr>
        </thead>
        <tbody class="tbody">
            <tr  v-for="group in groups" v-bind:key="group.userId">
                <td class="group-name">{{ group.groupName }}</td>
                <td class="playing-day">{{ group.gameDay }}</td>
                <td class="playing-time">{{ group.startTime }}</td>
                <td class="playing-type">{{ group.gameType }} </td>
                <td class="playing-location">{{ group.location}}</td>
                <td class="playing-location-address">{{ group.address }}</td>
                <td class="additional-info">{{ group.additionalInfo }}</td> 
                <td> 
                 <router-link v-bind:to="{ name: 'edit', params:{groupId: group.groupId}}"><p>Edit Group</p></router-link>
                </td>
                <td class="delete-itinerary"> <button type="submit" value="Delete" v-on:click="deleteGroup(group.groupId)">Delete</button></td>             
            </tr>
        </tbody>
      </table>


    </div>
  </template>
  
  <script>
  import GroupService from "../services/GroupService";
  import AuthService from "../services/AuthService";

  export default {
    name: "my-groups-card",
    props: [
        "userId", "groupId"
    ],
    data(){
        return {
            groups: [],

            users: [],
           
        }
    },
    created(){  
        const userId = this.$route.params.userId
        GroupService.getGroupsByUserId(userId).then((response) =>{
            this.groups = response.data;
            console.log(response.data);

        })

        AuthService.getUserByUserId(this.userId).then((response)=>{
            this.users = response.data;
        })
    },
    methods: {
      deleteGroup(groupId){
        GroupService.deleteGroup(groupId).then(()=>{
          const index = this.groups.findIndex(i => i.groupId == groupId)
          this.groups.splice(index, 1)
        })
      },


    }           
  
}

  </script>
  <style scoped>

  .table{
    table-layout: auto;
    border: 1px solid black;
    width: 100%;
  }

  .tbody{
    border: 1px solid black;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
  }
  .thead{
    background-color: rgb(32, 32, 31);
    color: white;
  }

  td{
    text-align: center;
  }
  
  
  </style>