let stories = [{id: 1, name: "Story 1"}, {id: 2, name: "Story 2"}]

export default {

  get() {
    return Promise.resolve(stories);
  },

}
