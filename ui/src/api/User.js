export default {

  login(user) {
    return Promise.resolve({id: 1, name: user.name});
  },

}
