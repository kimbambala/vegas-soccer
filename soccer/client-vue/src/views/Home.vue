<template>
  <div class="home">

    
    <main class="main-card">

      <playing-today />

    </main>
    
  </div>
</template>

<script>
import PlayingToday from "../components/PlayingToday.vue";
export default {
  name: "home",
  components:{
  PlayingToday 
  }
};
</script>
<style scoped>

.nav-bar{
  grid-area: nav-bar;
}

.side-bar{
  grid-area: side-bar;
  height: 100%;
}
.main-card{
  grid-area: main-card;
  background-color: rgb(211, 231, 239);
  box-shadow: inset 0px 5px 5px 0px rgb(175, 166, 166);
}

  
.home{
height: 100vh;
margin: 0;
display: grid;
grid-template-columns: 1fr 5fr 1fr;
grid-template-areas: 
". main-card ."
}


</style>