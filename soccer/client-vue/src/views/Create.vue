<template>
    <div class="main-card">  
        <header class= "nav-bar">
            <nav-bar />
        </header>

        <div class="create-group">
            <h1>Add a new group</h1>
            <form v-on:submit.prevent="onCreateGroup()">
                <div>
                    <label for="group-name">Group Name:</label>
                    <input type="text" id="group-name" name="group-name" v-model="group.groupName" required>
                </div>

                <div>
                    <label for="game-day">Game Day:</label>
                    <input type="text" id="game-day" name="game-day" v-model="group.gameDay" required>
                </div>

                <div>
                    <label for="start-time">Start Time:</label>
                    <input type="text" id="start-time" name="start-time" v-model="group.startTime" required>
                </div>

                <div>
                    <label for="game-type">Game Type:</label>
                    <input type="text" id="game-type" name="game-type" v-model="group.gameType" required>
                </div>

                <div>
                    <label for="location">Location:</label>
                    <input type="text" id="location" name="location" v-model="group.location" required>
                </div>

                <div>
                    <label for="address">Adress:</label>
                    <input type="text" id="address" name="address" v-model="group.address" required>
                </div>

                <div>
                    <label for="additional-info">Additional Info:</label>
                    <input type="text" id="additional-info" name="additional-info" v-model="group.additionalInfo">
                </div>
                <button type="submit" value="Create Group">Create Group </button>

            </form>
       
        </div>



    </div>
  </template>
  
  <script>
  import GroupService from "../services/GroupService";
  import AuthService from "../services/AuthService";
  import NavBar from "../components/NavBar.vue";

  export default {
    name: "create",
    props: [
        "userId", "groupId"
    ],
    components: {
        NavBar
    },
    data(){
        return {
            groups: [

            ],

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
            },
           
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
      onCreateGroup(){
            GroupService.createGroup(this.group).then((response)=>{
                console.log(response.data);

                const route = {
                    name: "profile",
                    params: {
                        
                        userId: this.$store.state.user.id,
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