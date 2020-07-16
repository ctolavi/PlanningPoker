import axios from 'axios';

const RESOURCE_NAME = '/users';

export default {

  get() {
    return axios.get(RESOURCE_NAME).then(
      response => {
        return response.data;
      }
    );
  },

  save(user) {
    return axios.post(RESOURCE_NAME, user).then(
      response => {
        return response.data;
      }).catch(error => {
        throw(error.response);
      }
    );
  },

  saveRoomByUser(userId, room) {
    return axios.post(RESOURCE_NAME + "/" + userId + "/rooms", room).then(
      response => {
        return response.data;
      }
    ).catch(error => {
        throw(error.response);
      }
    );
  }
}

