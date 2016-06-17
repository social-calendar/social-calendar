//首页 活动列表
import React from 'react';
import ReactDOM from 'react-dom';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import {List, ListItem} from 'material-ui/List';
import {tealA700} from 'material-ui/styles/colors';
import Subheader from 'material-ui/Subheader';
import Divider from 'material-ui/Divider';
import Avatar from 'material-ui/Avatar';
import ActionAssignment from 'material-ui/svg-icons/action/assignment';
import FloatingActionButton from 'material-ui/FloatingActionButton';
import ContentAdd from 'material-ui/svg-icons/content/add';

injectTapEventPlugin();


//首页活动列表
let back={
    backgroundColor:'green',
}
let addButtonPos={
    position:'fixed',
    right:'10px',
    bottom:'15%',
    zIndex:999
}
const ActiveList=()=>(
    <div>
        <div style={{backgroundColor:'white'}}>
            <List>
                <Subheader>05月12日 周四</Subheader>
                <ListItem
                    leftAvatar={<Avatar icon={<ActionAssignment />} backgroundColor={tealA700} />}
                    primaryText="15:30-16:30"
                    secondaryText="去游泳"
                    href="/detail.html?activeId=123"
                />
                <Divider insert={true} />
                <ListItem
                    leftAvatar={<Avatar icon={<ActionAssignment />} backgroundColor={tealA700} />}
                    primaryText="15:30-16:30"
                    secondaryText="去郊游"
                    href="/detail.html?activeId=123"
                />
            </List>
            <Divider insert={true} />
            <List>
                <Subheader style={{backgroundColor:'#00BFA5',color:'white'}}>今天 05月14日 周六</Subheader>
                <ListItem
                    leftAvatar={<Avatar icon={<ActionAssignment />} backgroundColor={tealA700} />}
                    primaryText="09:30-10:30"
                    secondaryText="去上课"
                    href="/detail.html?activeId=123"
                />
            </List>
        </div>
        <FloatingActionButton 
            style={addButtonPos} 
            secondary={true} 
            href="/add.html"
            linkButton={true}
        >
          <ContentAdd />
        </FloatingActionButton>
    </div>
);

ReactDOM.render(
   <MuiThemeProvider muiTheme={getMuiTheme()}>
    <ActiveList />
   </MuiThemeProvider>,
   document.getElementsByClassName('home')[0] 
);
