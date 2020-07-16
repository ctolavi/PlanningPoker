import axios from 'axios';

const RESOURCE_NAME = '/rooms';

export default {

  get() {
    return axios.get(RESOURCE_NAME).then(
      response => {
        return response.data;
      }
    );
  },

  saveStoryByRoom(roomId, story) {
    return axios.post(RESOURCE_NAME + "/" + roomId + "/user-stories", story).then(
      response => {
        return response.data;
      }
    ).catch(error => {
        throw(error.response);
      }
    );
  },

  getStoryByRoom(roomId) {
    return axios.get(RESOURCE_NAME + "/" + roomId + "/user-stories").then(
      response => {
        return response.data;
      }
    );
  },

}
