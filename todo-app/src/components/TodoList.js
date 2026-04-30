function TodoList({ todos, deleteTodo }) {
  return (
    <ul>
      {todos.map((t, i) => (
        <li key={i}>
          {t}
          <button onClick={() => deleteTodo(i)}>Delete</button>
        </li>
      ))}
    </ul>
  );
}

export default TodoList;