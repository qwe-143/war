import { useState } from "react";

function TodoInput({ addTodo }) {
  const [task, setTask] = useState("");

  const handleAdd = () => {
    if (task === "") return;
    addTodo(task);
    setTask("");
  };

  return (
    <div>
      <input
        placeholder="Enter task"
        value={task}
        onChange={(e) => setTask(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>
    </div>
  );
}

export default TodoInput;