<template>
    <div class="profile-card">
        <form v-on:submit.prevent="onCreateGroup()">
            <div>
                <label for="group-name">Group Name:</label>
                <input type="text" id="group-name" name="group-name" v-model="group.groupName">
            </div>

            <div>
                <label for="game-day">Game Day:</label>
                <input type="text" id="game-day" name="game-day" v-model="group.gameDay">
            </div>

            <div>
                <label for="start-time">Start Time:</label>
                <input type="text" id="start-time" name="start-time" v-model="group.startTime">
            </div>

            <div>
                <label for="game-type">Game Type:</label>
                <input type="text" id="game-type" name="game-type" v-model="group.gameType">
            </div>

            <div>
                <label for="location">Location:</label>
                <input type="text" id="location" name="location" v-model="group.location">
            </div>

            <div>
                <label for="address">Adress:</label>
                <input type="text" id="address" name="address" v-model="group.address">
            </div>

            <div>
                <label for="additional-info">Additional Info:</label>
                <input type="text" id="additional-info" name="additional-info" v-model="group.additionalInfo">
            </div>
            <button type="submit" value="Create Group">Create Group </button>

        </form>
       
    </div>
  </template>
  
  <script>
  import GroupService from "../services/GroupService";
  import AuthService from "../services/AuthService";

  export default {
    name: "profile-card",
    props: ["userId"],
    data(){
        return {

            users: [],

            group: {
                userId: this.$store.state.user.id,
                groupName: "",
                gameDay: "",
                startTime: "",
                gameType: "",
                location: "",
                address: "", 
                additionalInfo: ""
            }
        }
    },
    created(){
        AuthService.getUserByUserId(this.userId).then((response)=>{
            this.users = response.data;
        })


    },
    methods: {
      onCreateGroup(){
            GroupService.createGroup(this.group).then((response)=>{
                console.log(response.data);
                const userId = response.data.userId;

                const route = {
                    name: "Confirmation",
                    params: {
                        userId: userId
                    }
                };
                this.$router.push(route)
            })
  
            
  
    
  }
}
  }

  </script>
  <style scoped>
  
  </style>