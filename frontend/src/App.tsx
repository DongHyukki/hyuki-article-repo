import React from 'react';
import {Article} from "./entities";

function App() {
  return (
      <AppContainer>
          <Article />
      </AppContainer>
  );
}

function AppContainer({children}: {children: React.ReactNode}) {
    return (
        <div className='container'>
            <div className='flex justify-items-center'>
                {children}
            </div>
        </div>
    )
}

export default App;
