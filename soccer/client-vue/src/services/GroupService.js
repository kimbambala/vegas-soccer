import axios from 'axios';

export default {

  getMondayGroups(){
    return axios.get('/groups/monday/')
  },

  getTuesdayGroups(){
    return axios.get('/groups/tuesday/')
  },

  getWednesdayGroups(){
    return axios.get('/groups/wednesday/')
  },

  getThursdayGroups(){
    return axios.get('/groups/thursday/')
  },

  getFridayGroups(){
    return axios.get('/groups/friday/')
  },

  getSaturdayGroups(){
    return axios.get('/groups/saturday/')
  },

  getSundayGroups(){
    return axios.get('/groups/sunday/')
  }



}