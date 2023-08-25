<template>
    <div class="main-card">  
        <header class= "nav-bar">
            <nav-bar />
        </header>
        <main>
            <h1>Edit your group</h1>

            <div class="form-card" >
                <form v-on:submit.prevent="editGroup(group)">
                    <div>
                        <label for="edit-group-name">Group Name:</label>
                        <input type="text" id="edit-group-name" name="group-name" v-model="group.groupName" required>
                    </div>

                    <div>
                        <label for="edit-game-day">Game Day:</label>
                        <input type="text" id="edit-game-day" name="game-day" v-model="group.gameDay" required>
                    </div>

                    <div>
                        <label for="edit-start-time">Start Time:</label>
                        <input type="text" id="edit-start-time" name="start-time" v-model="group.startTime" required>
                    </div>

                    <div>
                        <label for="edit-game-type">Game Type:</label>
                        <input type="text" id="edit-game-type" name="game-type" v-model="group.gameType" required>
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
                    <button class="update-button-button" type="submit" value="Update Itinerary">Update Group</button>

                </form>
            
            </div>

        </main>
        



    </div>
  </template>
  
  <script>
  import GroupService from "../services/GroupService";
  import NavBar from "../components/NavBar.vue";

  export default {
    name: "edit",
    props: [
        "userId", "groupId"
    ],
    components: {
        NavBar
    },
    data(){
        return {
 
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
        const groupId = this.$route.params.groupId
        GroupService.getgroupbyId(groupId).then((response) =>{
            this.group = response.data;

        })




    },
    methods: {

      editGroup(group){
        GroupService.editGroup(group).then(()=>{
            
            //const userId = response.data.userId;
                const route = {
                    name: "profile",
                    params: {
                        
                        userId: this.$store.state.user.id,
                    }
                };
                this.$router.push(route)

     
        })
      },


    }           
  
}

  </script>
  <style scoped>

main{
    display: flex;
    flex-direction: column;
    align-items: center;

  }

.form-card{
    display: flex;
    align-items: center;
    
}

input{
    display: block;
    height: 40px;
    width: 800px;
    background-color: rgba(255, 255, 255, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-bottom: 8px;
    font-size: 25px;
    font-weight: 300;
}

input:hover{
    border-color: red;
    background-color: yellow;

}

h1{
    margin-top: 10px;

}

form{
    align-content: center;
    
}

label{
    font-size: 20px;
}

button{
    margin-top: 20px;
    width: 100%;
    height: 50px;
    background-color: #ffffff;
    color: #080710;
    padding: 2px 0;
    font-size: 25px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
    align-self: center;
}

button:hover{
    background-color: #080710;
    color: white;
}

  
  
  </style>