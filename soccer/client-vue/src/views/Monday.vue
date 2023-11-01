<template>
    <div class="monday-page">
      <monday-card />
      <main class="monday-card">
        <div class="playing-days">
          <button class="monday">
            <router-link v-bind:to="{ name: 'monday' }"><p>Monday</p></router-link>
          </button>

          <button class="tuesday">
            <router-link v-bind:to="{ name: 'tuesday' }"><p>Tuesday</p></router-link>
          </button>

          <button class="wednesday">
            <router-link v-bind:to="{ name: 'wednesday' }"><p>Wednesday</p></router-link>
          </button>

          <button class="thursday">
            <router-link v-bind:to="{ name: 'thursday' }"><p>Thursday</p></router-link>
          </button>

          <button class="friday">
            <router-link v-bind:to="{ name: 'friday' }"><p>Friday</p></router-link>
          </button>
          <button class="saturday">
            <router-link v-bind:to="{ name: 'saturday' }"><p>Saturday</p></router-link>
          </button>
          <button class="sunday">
            <router-link v-bind:to="{ name: 'sunday' }"><p>Sunday</p></router-link>
          </button>
        </div>
        

      </main>
      <footer class="card-footer">
        <img src="../assets/images/vegaspic2.jpeg" alt="">
        <div class="centered">Las Vegas Pickup Soccer</div>
      </footer>
      
    </div>
  </template>
  
  <script>
 import MondayCard from "../components/MondayCard";

  export default {
    name: "monday",
    components:{
      MondayCard
    }
  };
  </script>
  <style scoped>
  
  .monday-card{
  grid-area: main-card;
  background-color: rgb(211, 231, 239);
  box-shadow: inset 0px 5px 5px 0px rgb(175, 166, 166);
  margin-left: 170px;
  margin-right: 170px;
  padding-bottom: 20px;
}


.monday-page{
margin-top: 30px;

}


.monday{
  grid-area: monday;
}

.tuesday{
  grid-area: tuesday;
}

.wednesday{
  grid-area: wednesday;
}

.thursday{
  grid-area: thursday;
}

.friday{
  grid-area: friday;
}

.saturday{
  grid-area: saturday;
}

.sunday{
  grid-area: sunday
}

.playing-days{
  display: grid;
  grid-template-columns: 1fr, 1fr, 1fr, 1fr, 1fr, 1fr,1fr;
  grid-template-areas: 
   "monday tuesday wednesday thursday friday saturday sunday";

}

button{
  background-color: #CC9933;
  font-size: 20px;
  border: none;
  padding-top: 10px;
}

button:hover{
  background-color:  rgb(211, 231, 239);
}

.card-footer{
    height: 400px;
    margin-left: 170px;
    margin-right: 170px;
    position: relative;
}

img{
  margin-top: 10px;
  height: 100%;
  width: 100%;
}

.centered {
  position: absolute;
  top: 40%;
  text-align: center;
  padding-left: 200px;
  font-size: 60px;
  font-weight: 700;
  color: white;

}
  
  
  </style>