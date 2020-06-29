let rooms = [{id: 1, name: "Room1"}, {id: 2, name: "Room2"}]
export default {

  get() {
    return Promise.resolve(rooms);
  },

  getRoom(id) {
    let selectedRoom;
    rooms.forEach(
      room => {
        if (room.id === id) {
          selectedRoom = room;
        }
      }
    )
    return Promise.resolve(selectedRoom);
  },

  save(room) {
    let roomSaved = {
      id: rooms.length + 1,
      name: room.name,
    }
    rooms.push(roomSaved);
    return Promise.resolve(roomSaved);
  }

}
