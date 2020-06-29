let players = [{id: 1, name: "Mary"}, {id: 2, name: "Carlos"}]
export default {

  get() {
    return Promise.resolve(players);
  },

}
