import axios from 'axios';

export default {

  listAllGroups() {
    return axios.get('/groups')
  },

  getMondayGroups(){
    return axios.get('/groups/monday/')
  }



}