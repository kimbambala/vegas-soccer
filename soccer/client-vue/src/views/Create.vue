<template>
    <div class="main-card">  

        <main>
            <h1>Add a new group</h1>
                <div class="form-card">
                <form v-on:submit.prevent="onCreateGroup()">
                    <div>
                        <label for="group-name">Group Name:</label>
                        <input type="text" id="group-name" name="group-name" v-model="group.groupName" required>
                    </div>

                    <div>
                        <label for="game-day">Game Day:</label>
                        <select id="game-day" name="game-day" v-model="group.gameDay" required>
                            <option class="option-text" value="">--Please choose a day--</option>
                            <option value="Monday">Monday</option>
                            <option value="Tuesday">Tuesday</option>
                            <option value="Wednesday">Wednesday</option>
                            <option value="Thursday">Thursday</option>
                            <option value="Friday">Friday</option>
                            <option value="Saturday">Saturday</option>
                            <option value="Sunday">Sunday</option>
                        </select>
                    </div>

                    <div>
                        <label for="start-time">Start Time:</label>
                        <select id="start-time" name="start-time" v-model="group.startTime" required>
                            <option class="option-text" value="">--Please choose the starting time--</option>
                            <option value="6AM">6 AM</option>
                            <option value="7AM">7 AM</option>
                            <option value="8AM">8 AM</option>
                            <option value="9AM">9 AM</option>
                            <option value="10AM">10 AM</option>
                            <option value="11AM">11 AM</option>
                            <option value="12PM">12 PM</option>
                            <option value="1PM">1 PM</option>
                            <option value="2PM">2 PM</option>
                            <option value="3PM">3 PM</option>
                            <option value="4PM">4 PM</option>
                            <option value="5PM">5 PM</option>
                            <option value="6PM">6 PM</option>
                            <option value="7PM">7 PM</option>
                            <option value="8PM">8 PM</option>
                            <option value="9PM">9 PM</option>
                            <option value="10PM">10 PM</option>
                        </select>
                    </div>

                    <div>
                        <label for="game-type">Game Type:</label>
                        <select id="game-day" name="game-type" v-model="group.gameType" required>
                            <option class="option-text" value="">--Please choose a game type--</option>
                            <option value="Indoor">Indoor</option>
                            <option value="Outdoor">Outdoor</option>

                        </select>
                    </div>

                    <div>
                        <label for="location">Location Name:</label>
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

        </main>
        <footer class="card-footer">

        </footer>

    </div>
  </template>
  
  <script>
  import GroupService from "../services/GroupService";
  import AuthService from "../services/AuthService";


  export default {
    name: "create",
    props: [
        "userId", "groupId"
    ],

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
    width: 700px;
    background-color: rgba(255, 255, 255, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-bottom: 8px;
    font-size: 25px;
    font-weight: 400;
}

select{
    display: block;
    background-color: rgba(255, 255, 255, 0.07);
    width: 700px;
    height: 40px;
    font-size: 25px;
    border-radius: 3px;

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

input:hover, select:hover{
    border-color: red;
    background-color: #CC9933;

}

.card-footer{
    height: 50px;
}

  
  
  </style>