let stories = [{id: 1, name: "Story 1"}, {id: 2, name: "Story 2"}]

export default {

  get() {
    return Promise.resolve(stories);
  },

  save(story) {
    let storySaved = {
      id: stories.length + 1,
      name: story.value,
    }
    stories.push(storySaved);
    return Promise.resolve(storySaved);
  }

}
