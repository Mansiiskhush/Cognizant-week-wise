import React from "react";

export default class Post extends React.Component {
  render() {
    const { title, body } = this.props;
    return (
      <div>
        <h2>{title}</h2>
        <p>{body}</p>
      </div>
    );
  }
}
