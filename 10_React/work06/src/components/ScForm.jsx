import React from "react";
// 분리된 컴포넌트에서 필요한 부분인 배열과 삭제용 함수 파라미터에 집어넣기, 중괄호 필수!
function ScForm({ todoList, todoDelete }) {
  return (
    <table border="1">
      <thead>
        <tr>
          <th>할 일</th>
          <th>마감일</th>
          <th>작업</th>
        </tr>
      </thead>
      <tbody>
        {todoList.map((t, index) => (
          <tr>
            <td>{t.work}</td>
            <td>{t.date}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  todoDelete(index);
                }}
              />
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
export default ScForm;
